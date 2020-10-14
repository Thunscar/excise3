package dao;

import tools.JdbcUtil;
import vo.Area;
import vo.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AreaDao {
    public ArrayList<Area> getAreaProvince(){
        ArrayList<Area> areas = new ArrayList<>();

        Connection con = JdbcUtil.getConnection();
        String sql = "select * from t_province";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                areas.add(new Area(rs.getString("areaId"),rs.getString("areaName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.closeAll(rs,ps,con);
        return areas;
    }

    public ArrayList<City> getCityListByAreaId(String areaId){
        ArrayList<City> cityList = new ArrayList<>();

        Connection con = JdbcUtil.getConnection();
        String sql = "SELECT * from t_city where areaId = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,areaId);
            rs = ps.executeQuery();
            while (rs.next()){
                cityList.add(new City(rs.getInt("id"),rs.getString("areaId"),rs.getString("cityName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JdbcUtil.closeAll(rs,ps,con);
        return cityList;
    }
}
