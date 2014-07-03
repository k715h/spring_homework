package repository;

import vo.BoardVO;
import vo.UserVO;

import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: coupang
 * Date: 2014. 7. 2.
 * Time: 오후 5:53
 * To change this template use File | Settings | File Templates.
 */
public class Database {
    private Hashtable<Long, UserVO> userTable = new Hashtable<Long, UserVO>();
    private Hashtable<Long, BoardVO> boardTable = new Hashtable<Long, BoardVO>();

    private Database() {}
    private static Database database = new Database();
    public static Database getDatabase() {
        return database;
    }

    public Hashtable<Long, UserVO> getUserTable() {
        return userTable;
    }

    public Hashtable<Long, BoardVO> getBoardTable() {
        return boardTable;
    }
}
