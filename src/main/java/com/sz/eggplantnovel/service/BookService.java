package com.sz.eggplantnovel.service;

import com.sz.eggplantnovel.core.common.req.PageReqDto;
import com.sz.eggplantnovel.core.common.resp.PageRespDto;
import com.sz.eggplantnovel.core.common.resp.RestResp;
import com.sz.eggplantnovel.dto.req.BookAddReqDto;
import com.sz.eggplantnovel.dto.req.ChapterAddReqDto;
import com.sz.eggplantnovel.dto.resp.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * 小说模块 服务类
 *
 * @author sz
 * @version 1.0
 * @date 2022/11/14
 */
public interface BookService {

    /**
     * 小说点击榜查询
     *
     * @return 小说点击排行列表
     */
    RestResp<List<BookRankRespDto>> listVisitRankBooks();

    /**
     * 小说新书榜查询
     *
     * @return 小说更新排行列表
     */
    RestResp<List<BookRankRespDto>> listNewestRankBooks();

    /**
     * 小说信息查询
     *
     * @param bookId 小说Id
     * @return 内容相关联的信息
     */
    RestResp<List<BookInfoRespDto>> getBookContentAbout(Long bookId);

    /**
     * 小说内容相关信息查询
     *
     * @param bookId 小说ID
     * @return 内容相关联的列表
     */
    RestResp<BookChapterAboutRespDto> getLastChapterAbout(Long bookId);

    /**
     * 小说推荐列表查询
     *
     * @param bookId 小说ID
     * @return 小说信息列表
     * @throws NoSuchAlgorithmException
     */
    RestResp<BookInfoRespDto> listRecBooks(Long bookId) throws NoSuchAlgorithmException;

    /**
     * 增加小说点击量
     *
     * @param chapterId 小说ID
     * @return 成功状态
     */
    RestResp<Void> addVisitCount(Long chapterId);

    /**
     * 获取上一章节ID
     *
     * @param chapterId 章节ID
     * @return 上一章节ID
     */
    RestResp<Long> getPreChapterId(Long chapterId);

    /**
     * 获取下一章节ID
     *
     * @param chapterId 章节ID
     * @return 下一章节ID
     */
    RestResp<Long> getNextChapterId(Long chapterId);

    /**
     * 小说章节列表查询
     *
     * @param bookId 小说ID
     * @return 小说章节列表
     */
    RestResp<List<BookChapterRespDto>> listChapters(Long bookId);

    /**
     * 小说分类列表查询
     *
     * @param workDirection 作品方向；0-男频 1-女频
     * @return
     */
    RestResp<List<BookCategoryRespDto>> listCategory(Integer workDirection);

    /**
     * 发表评论
     *
     * @param dto 评论相关 Dto
     * @return
     */
    RestResp<Void> saveComment(UserCommentReqDto dto);

    /**
     * 小说最新评论查询
     *
     * @param bookId 小说ID
     * @return 小说最新评论数据
     */
    RestResp<BookComentRepDto> listNewestComments(Long bookId);

    /**
     * 删除评论
     *
     * @param userId  评论用户ID
     * @param commentId 评论ID
     * @return void
     */
    RestResp<Void> deleteComment(Long userId, Long commentId);

    /**
     * 修改评论
     *
     * @param userId 用户ID
     * @param id    评论ID
     * @param content 修改后的评论内容
     * @return
     */
    RestResp<Void> updateComment(Long userId, Long id, String content);

    /**
     * 小说信息保存
     *
     * @param dto 小说信息
     * @return void
     */
    RestResp<Void> saveBook(BookAddReqDto dto);

    /**
     * 小说章节信息保存
     *
     * @param dto 章节信息
     * @return void
     */
    RestResp<Void> saveBookChapter(ChapterAddReqDto dto);

    /**
     * 查询作家发布小说列表
     *
     * @param dto 分页请求参数
     * @return 小说分页列表数据
     */
    RestResp<PageRespDto<BookInfoRespDto>> listAuthorBooks(PageReqDto dto);

    /**
     * 查询小说发布章节列表
     *
     * @param bookId 小说ID
     * @param dto 分页请求参数
     * @return 章节分页列表数据
     */
    RestResp<PageRespDto<BookChapterRespDto>> listBookChapters(Long bookId, PageReqDto dto);
}
