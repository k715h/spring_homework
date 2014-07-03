import dao.BoardTableDao;
import dao.DatabaseDao;
import dao.UserTableDao;
import vo.BoardVO;
import vo.UserVO;
import vo.VO;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: coupang
 * Date: 2014. 7. 2.
 * Time: 오후 5:21
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseImplTest {
    @org.junit.Test
    public void testFindAll() throws Exception {
        DatabaseDao testDatabaseDao = UserTableDao.getUserTableDao();
        UserVO testVO = new UserVO("테스트1","루나1",26,"인천");
        UserVO testVO2 = new UserVO("테스트2","루나2",20,"서울");
        testDatabaseDao.insert(testVO);
        testDatabaseDao.insert(testVO2);
        List<UserVO> exceptionList = new ArrayList<UserVO>();
        exceptionList.add(testVO);
        exceptionList.add(testVO2);
        List<UserVO> resultList = testDatabaseDao.findAll();
//        System.out.println(resultList.get(0));
//        System.out.println(resultList.get(1));
//        assertThat(resultList.get(0), is(exceptionList.get(0)));
//        assertThat(resultList.get(1), is(exceptionList.get(1)));

    }

    @org.junit.Test
    public void testFindOne() throws Exception {
        DatabaseDao testDatabaseDao = UserTableDao.getUserTableDao();
        VO testVO = new UserVO("테스트1","루나1",26,"인천");
        VO testVO2 = new UserVO("테스트2","루나2",20,"서울");
        testDatabaseDao.insert(testVO);
        testDatabaseDao.insert(testVO2);
        VO result = testDatabaseDao.findOne(1L);
        assertThat(result, is(testVO));
        VO result2 = testDatabaseDao.findOne(3L);
        assertNull(result2);


    }

    @org.junit.Test
    public void testInsert() throws Exception {
        DatabaseDao testDatabaseDao = UserTableDao.getUserTableDao();
        UserVO testVO = new UserVO("","루나",26,"인천");
        testDatabaseDao.insert(testVO);
        assertThat(testDatabaseDao.tableSize(),is(1));
        DatabaseDao testOtherDatabase = UserTableDao.getUserTableDao();
        VO testVO2 = new UserVO("테스트2","루나2",20,"서울");
        testOtherDatabase.insert(testVO2);
        assertThat(testOtherDatabase.tableSize(),is(2));
        DatabaseDao testBoardDatabase = BoardTableDao.getBoardTableDao();
        BoardVO testBoard = new BoardVO("제목", "내용");
        testBoardDatabase.insert(testBoard);
        assertThat(testBoardDatabase.tableSize(), is(1));
        assertThat(testBoard.getId(), is(1L));
        assertThat(testVO2.getId(),is(2L));
    }



    @org.junit.Test
    public void testUpdate() throws Exception {
        DatabaseDao testDatabaseDao = UserTableDao.getUserTableDao();
        VO testVO = new UserVO("김혜영","루나",26,"인천");
        testDatabaseDao.insert(testVO);
        VO testVO2 = new UserVO("테스트","테스트",20,"서울");
        testVO2.setId(1L);
        assertThat(testDatabaseDao.update(testVO2), is(true));
        assertThat(testDatabaseDao.findOne(1L),is(testVO2));

    }

    @org.junit.Test
    public void testDelete() throws Exception {
        DatabaseDao testDatabaseDao = UserTableDao.getUserTableDao();
        VO testVO = new UserVO("테스트1","루나1",26,"인천");
        VO testVO2 = new UserVO(2L, "테스트1","루나1",26,"인천");
        testDatabaseDao.insert(testVO);
//        testDatabaseDao.insert(testVO2);
        boolean result = testDatabaseDao.delete(testVO2);
//        assertThat(testDatabaseDao.tableSize(), is(1));
        assertFalse(result);
    }
}
