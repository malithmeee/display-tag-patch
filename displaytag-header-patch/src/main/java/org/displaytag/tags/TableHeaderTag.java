package org.displaytag.tags;

import org.displaytag.exception.TagStructureException;
import org.displaytag.properties.MediaTypeEnum;
import org.displaytag.util.MediaUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bharat
 * Date: 11/15/11
 * Time: 7:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TableHeaderTag extends BodyTagSupport implements MediaUtil.SupportsMedia {

    /**
     * D1597A17A6.
     */
    private static final long serialVersionUID = 899149338534L;

    /**
     * The media supported attribute.
     */
    private List supportedMedia;

    /**
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     */
    public int doEndTag() throws JspException {
        TableTag tableTag = (TableTag) findAncestorWithClass(this, TableTag.class);

        if (tableTag == null) {
            throw new TagStructureException(getClass(), "header", "table");
        }

        MediaTypeEnum currentMediaType = (MediaTypeEnum) this.pageContext.findAttribute(TableTag.PAGE_ATTRIBUTE_MEDIA);
        if (currentMediaType != null && !MediaUtil.availableForMedia(this, currentMediaType)) {
            return SKIP_BODY;
        }

        if (tableTag.isLastIteration()) {
            if (getBodyContent() != null) {
                tableTag.setHeader(getBodyContent().getString());
            }
        }

        return EVAL_PAGE;
    }


    /**
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    public int doStartTag() throws JspException {
        TableTag tableTag = (TableTag) findAncestorWithClass(this, TableTag.class);

        if (tableTag == null) {
            throw new TagStructureException(getClass(), "header", "table");
        }

        MediaTypeEnum currentMediaType = (MediaTypeEnum) this.pageContext.findAttribute(TableTag.PAGE_ATTRIBUTE_MEDIA);
        if (!MediaUtil.availableForMedia(this, currentMediaType)) {
            return SKIP_BODY;
        }

        // using int to avoid deprecation error in compilation using j2ee 1.3 (EVAL_BODY_TAG)
        return 2;
    }

    /**
     * @see org.displaytag.util.MediaUtil.SupportsMedia#setSupportedMedia(java.util.List)
     */
    public void setSupportedMedia(List media) {
        this.supportedMedia = media;
    }

    /**
     * @see org.displaytag.util.MediaUtil.SupportsMedia#getSupportedMedia()
     */
    public List getSupportedMedia() {
        return this.supportedMedia;
    }

    /**
     * Tag setter.
     *
     * @param media the space delimited list of supported types
     */
    public void setMedia(String media) {
        MediaUtil.setMedia(this, media);
    }

    /**
     * @see javax.servlet.jsp.tagext.Tag#release()
     */
    public void release() {
        this.supportedMedia = null;
        super.release();
    }
}
