package com.sz.eggplantnovel.core.listener;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.sz.eggplantnovel.core.constant.AmqpConsts;
import com.sz.eggplantnovel.core.constant.EsConsts;
import com.sz.eggplantnovel.dao.entity.BookInfo;
import com.sz.eggplantnovel.dao.mapper.BookInfoMapper;
import com.sz.eggplantnovel.dto.es.EsBookDto;
import com.sz.eggplantnovel.dto.resp.BookInfoRespDto;
import com.sz.eggplantnovel.manager.Cache.BookInfoCacheManager;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author sz
 * @version 1.0
 * @date 2023/1/1
 */

@Component
@ConditionalOnProperty(prefix = "spring", name = {"elasticsearch.enabled",
        "amqp.enabled"}, havingValue = "true")
@RequiredArgsConstructor
@Slf4j
public class RabbitQueueListener {

    private final BookInfoMapper bookInfoMapper;

    private final BookInfoCacheManager bookInfoCacheManager;

    private final ElasticsearchClient esClient;

    /**
     * 监听小说信息改变的 ES 更新队列，更新最新小说信息到 ES
     */
    @RabbitListener(queues = AmqpConsts.BookChangeMq.QUEUE_ES_UPDATE)
    @SneakyThrows
    public void updateEsBook(Long bookId) {
        BookInfo bookInfo = bookInfoMapper.selectById(bookId);
        // 更新小说信息缓存
        BookInfoRespDto bookInfoRespDto = bookInfoCacheManager.cachePutBookInfo(bookId);
        IndexResponse response = esClient.index(i -> i
                .index(EsConsts.BookIndex.INDEX_NAME)
                .id(bookInfo.getId().toString())
                .document(EsBookDto.build(bookInfo))
        );
        log.info("Indexed with version " + response.version());
    }
}
