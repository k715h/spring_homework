package vo;

/**
 * Created with IntelliJ IDEA.
 * User: coupang
 * Date: 2014. 7. 2.
 * Time: 오후 3:28
 * To change this template use File | Settings | File Templates.
 */
public abstract class VO {
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VO vo = (VO) o;

        if (!id.equals(vo.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
