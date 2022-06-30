import DTO.Item;

import java.sql.*;

public class DBClass {
    // 여기서 만들어 사용가능한 것
    // 생성자
    // 변수
    // 메소드

    //db 연결 메소드
    public Connection dbConn() {
        final String driver = "org.mariadb.jdbc.Driver";
        final String DB_IP = "localhost";
        final String DB_PORT = "3306";
        final String DB_NAME = "mydb";
        final String DB_USER = "root";
        final String DB_PASS = "1234";
        final String DB_URL =
                "jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

        //java 와 db 연결
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            if (conn != null) {
                System.out.println("DB 접속 성공");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
        return conn;
    }

    //character 데이터 삽입 메소드
    public void insertCharacter(String name, String hp, String job) {

        //쿼리문 준비
        String sql = "INSERT INTO `tb_character` (`name`, `hp`, `job`) VALUES (?,?,?)";
        PreparedStatement pstmt = null;
        Connection conn = dbConn();
        //db 연결 메소드에서 return값을 이용해 데이터 삽입 메소드에서 conn을 사용할 수 있도록 만든다

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, hp);
            pstmt.setString(3, job);

            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("데이터 삽입 성공!");
            }

        } catch (Exception e) {
            System.out.println("데이터 삽입 실패!");
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //character 데이터 조회(검색) 메소드
    public void selectCharacter() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = dbConn();

        try {
            String sql = "select * from tb_character";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String hp = rs.getString("hp");
                String job = rs.getString("job");

                System.out.println("캐릭터 이름 : " + name + " / HP : " + hp + " / 직업 : " + job);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //item 데이터 삽입 메소드
    public void insertItem(String name, String att, String dam, String hyo) {

        //쿼리문 준비
        String sql = "INSERT INTO `item` (`name`, `att`, `dam`, `hyo`) VALUES (?,?,?,?)";
        PreparedStatement pstmt = null;
        Connection conn = dbConn();
        //db 연결 메소드에서 return값을 이용해 데이터 삽입 메소드에서 conn을 사용할 수 있도록 만든다

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, att);
            pstmt.setString(3, dam);
            pstmt.setString(4, hyo);

            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("데이터 삽입 성공!");
            }

        } catch (Exception e) {
            System.out.println("데이터 삽입 실패!");
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void insertItem(Item item) {

        //쿼리문 준비
        String sql = "INSERT INTO `item` (`name`, `att`, `dam`, `hyo`) VALUES (?,?,?,?)";
        PreparedStatement pstmt = null;
        Connection conn = dbConn();
        //db 연결 메소드에서 return값을 이용해 데이터 삽입 메소드에서 conn을 사용할 수 있도록 만든다

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getAtt());
            pstmt.setInt(3, item.getDam());
            pstmt.setString(4, item.getHyo());

            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("데이터 삽입 성공!");
            }

        } catch (Exception e) {
            System.out.println("데이터 삽입 실패!");
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //item 데이터 조회(검색) 메소드
    public void selectItem() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = dbConn();

        try {
            String sql = "select * from item";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String att = rs.getString("att");
                String dam = rs.getString("dam");
                String hyo = rs.getString("hyo");

                System.out.println("아이템 이름 : " + name + " / 속성 : " + att +
                        " / 데미지 : " + dam + " / 효과: " + hyo);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //monster 데이터 삽입 메소드
    public void insertMonster(String name, String hp) {

        //쿼리문 준비
        String sql = "INSERT INTO `monster` (`name`, `hp`) VALUES (?,?)";
        PreparedStatement pstmt = null;
        Connection conn = dbConn();
        //db 연결 메소드에서 return값을 이용해 데이터 삽입 메소드에서 conn을 사용할 수 있도록 만든다

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, hp);

            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("데이터 삽입 성공!");
            }

        } catch (Exception e) {
            System.out.println("데이터 삽입 실패!");
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //monster 데이터 조회(검색) 메소드
    public void selectMonster() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = dbConn();

        try {
            String sql = "select * from monster";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String hp = rs.getString("hp");

                System.out.println("몬스터 이름 : " + name + " / HP : " + hp);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
