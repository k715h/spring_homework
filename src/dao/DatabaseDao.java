package dao;

import repogitory.Database;
import vo.VO;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: coupang
 * Date: 2014. 7. 2.
 * Time: 오후 4:54
 * To change this template use File | Settings | File Templates.
 */
public abstract class DatabaseDao<T extends VO> {
    protected Database database;
    protected Hashtable<Long, T> table;

    protected DatabaseDao() {
        database = Database.getDatabase();
    }
    public int tableSize() {
        return table.size();
    }

    public void setTable(Hashtable table) {
        this.table = table;
    }

    public List<T> findAll() {
        Enumeration list = table.elements();
        List<T> allList = Collections.list(list);
        return allList;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public T findOne(Long id) {
        return table.get(id);
    }

    public abstract boolean insert(T t);

    public abstract boolean update(T t);

    public boolean delete(VO vo) {
        if(table.containsKey(vo.getId())) {
            table.remove(vo.getId());
            return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
