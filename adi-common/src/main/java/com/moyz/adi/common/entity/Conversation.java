package com.moyz.adi.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会话表
 * </p>
 *
 * @author moyz
 * @since 2023-04-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("adi_conversation")
@Schema(title = "对话实体", description = "对话表")
public class Conversation extends BaseEntity {

    @Schema(title = "用户id")
    @TableField("user_id")
    private Long userId;

    @Schema(title = "对话uuid")
    @TableField("uuid")
    private String uuid;

    @Schema(title = "会话标题")
    @TableField("title")
    private String title;

    @Schema(title = "描述")
    @TableField("remark")
    private String remark;

    @Schema(title = "消耗的token数量")
    @TableField("tokens")
    private Integer tokens;

    @Schema(name = "是否开启理解上下文的功能")
    @TableField("understand_context_enable")
    private Boolean understandContextEnable;

    @Schema(title = "设置系统信息(角色设定内容) | Set the system message to ai, ig: you are a lawyer")
    @TableField("ai_system_message")
    private String aiSystemMessage;

    @Schema(title = "请求LLM时的temperature")
    @TableField("llm_temperature")
    private Double llmTemperature;

    @Schema(title = "启用的mcp服务id列表")
    @TableField("mcp_ids")
    private String mcpIds;

    @Schema(title = "设置响应内容类型：1：自动（跟随用户的输入类型，如果用户输入是音频，则响应内容也同样是音频，如果用户输入是文本，则响应内容显示文本），2：文本，3：音频")
    @TableField("answer_content_type")
    private Integer answerContentType;

    @Schema(title = "设置聊天时音频类型的响应内容是否自动播放")
    @TableField("is_autoplay_answer")
    private Boolean isAutoplayAnswer;
}
