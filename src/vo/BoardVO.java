package vo;

/**
 * Created with IntelliJ IDEA.
 * User: coupang
 * Date: 2014. 7. 3.
 * Time: 오후 3:36
 * To change this template use File | Settings | File Templates.
 */
public class BoardVO extends VO {
    private String title;
    private String content;

    public BoardVO() {}

    public BoardVO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
