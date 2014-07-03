package dao;

import vo.UserVO;

/**
 * Created with IntelliJ IDEA.
 * User: coupang
 * Date: 2014. 7. 2.
 * Time: 오후 6:46
 * To change this template use File | Settings | File Templates.
 */
public class UserTableDao extends DatabaseDao<UserVO> {
    private static Long id;

    private UserTableDao() {
        super.setTable(database.getUserTable());
        id = 1L;
    }
    private static UserTableDao userTableDao = new UserTableDao();
    public static UserTableDao getUserTableDao() {
        return userTableDao;
    }

    @Override
    public boolean insert(UserVO userVO) {
        if(table.containsKey(id)) {
            return false;
        }
        userVO.setId(id);
        table.put(userVO.getId(), userVO);
        id++;
        return true;
    }

    @Override
    public boolean update(UserVO userVO) {
        if(table.containsKey(userVO.getId())) {
            table.put(userVO.getId(), userVO);
            return true;
        }
        return false;
    }

}
