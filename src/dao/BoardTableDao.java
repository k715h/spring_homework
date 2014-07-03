package dao;

import vo.BoardVO;

/**
 * Created with IntelliJ IDEA.
 * User: coupang
 * Date: 2014. 7. 3.
 * Time: 오후 3:37
 * To change this template use File | Settings | File Templates.
 */
public class BoardTableDao extends DatabaseDao<BoardVO> {
    private static Long id;
    private BoardTableDao() {
        super.setTable(database.getBoardTable());
        id = 1L;
    }
    private static BoardTableDao boardTableDao = new BoardTableDao();
    public static BoardTableDao getBoardTableDao() {
        return boardTableDao;
    }

    @Override
    public boolean insert(BoardVO boardVO) {
        if(table.containsKey(id)) {
            return false;
        }
        boardVO.setId(id);
        table.put(id, boardVO);
        id++;
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean update(BoardVO boardVO) {
        if(table.containsKey(boardVO.getId())) {
            table.put(boardVO.getId(), boardVO);
            return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
