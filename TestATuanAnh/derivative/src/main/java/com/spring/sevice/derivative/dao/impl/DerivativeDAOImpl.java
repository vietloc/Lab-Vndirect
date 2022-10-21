package com.spring.sevice.derivative.dao.impl;

import com.spring.sevice.derivative.dao.DerivativeDAO;
import com.spring.sevice.derivative.model.Derivative;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//là bảo IoC container tạo một object duy nhất (singleton)---derivativeDAOImple là 1 module
@Component("derivativeDAO")
public class DerivativeDAOImpl implements DerivativeDAO {
    private final static Logger LOGGER = Logger.getLogger(String.valueOf(DerivativeDAOImpl.class));

    private DataSource dataSource;

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    private int totalElements;

    private int totalPage;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    private LocalSessionFactoryBean sessionFactoryBean;

    @Autowired
    public void setSessionFactoryBean(LocalSessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    public LocalSessionFactoryBean getSessionFactoryBean() {
        return sessionFactoryBean;
    }
    @Override
    public List<Derivative> list(int page,Integer size, String sort, String q){
        int start = (page - 1)*size;

        String sql = "SELECT * FROM derivative where 1=1 ";

        //filter
        if(q != null){
            //tao obj chua attribute
            String filAttribute = "";
            //tao obj chua chuoi duoc cut  :
            String filA[] = q.split(":");
            //gan vao attribute
            filAttribute=filA[0];
            LOGGER.info(filA[0]);

            String forFilter[]=filA[1].split(",");
            LOGGER.info(filA[1]);
            sql+="and " + filAttribute + " in(";

            for (int i = 0; i < forFilter.length; i++) {
                sql+="'"+forFilter[i]+"',";
            }
            //xoa dau , cuoi
            if(sql.endsWith(",")){
                sql = sql.substring(0, sql.length() - 1);
            }
            sql+=")";
        }
        //sort
        if(sort!=null){
            switch (sort){
                case "deriCode:desc":{
                    sql += "order by deri_composite_code desc";
                    break;
                }
                case "deriCode:asc":{
                    sql += "order by deri_composite_code asc";
                    break;
                }
            }
        }
        LOGGER.info(sql);
        this.totalElements = jdbcTemplate.query(sql, new DerivativeMapper()).size();
        List<Derivative> data = jdbcTemplate.query(sql+" limit " + start +","+size, new DerivativeMapper());
//        this.totalElements = data.size();
        this.totalPage = (int) Math.ceil((double) totalElements/ (double) size);
        return data;
    }


//    public List<Derivative> listForEle(){
//
//        String sql = "SELECT * FROM derivative where 1=1 ";
//
//        List<Derivative> data = jdbcTemplate.query(sql, new DerivativeMapper());
//        return data;
//    }
    private final static class DerivativeMapper implements RowMapper<Derivative>{
        @Override
        public Derivative mapRow(ResultSet resultSet, int i)throws SQLException{
            try{
                Derivative derivative = new Derivative();
                derivative.setDeri_composite_code(resultSet.getString("deri_composite_code"));
                derivative.setDerivative_code(resultSet.getString("derivative_code"));
                derivative.setEffective_date(resultSet.getDate("effective_date"));
                derivative.setExpiration_date(resultSet.getDate("expiration_date"));
                derivative.setCreated_date(resultSet.getDate("created_date"));
                derivative.setCreated_by(resultSet.getString("created_by"));
                derivative.setModified_date(resultSet.getDate("modified_date"));
                derivative.setModified_by(resultSet.getString("modified_by"));
                derivative.setUnderlying_type(resultSet.getString("underlying_type"));
                return derivative;
            }catch (Exception e){
                LOGGER.error(e,e);
                return null;
            }
        }
    }


//    public Derivative get(String deri_composite_code){
//        Session session = sessionFactoryBean.getObject().openSession();
//        try {
//            return session.get(Derivative.class, deri_composite_code);
//        } finally {
//            session.close();
//        }
//    }
}
