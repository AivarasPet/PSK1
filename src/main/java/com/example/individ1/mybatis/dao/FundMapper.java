package com.example.individ1.mybatis.dao;

import com.example.individ1.mybatis.model.Fund;
import java.util.List;
import org.mybatis.cdi.Mapper;
@Mapper
public interface FundMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FUND
     *
     * @mbg.generated Sat Apr 23 18:43:27 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FUND
     *
     * @mbg.generated Sat Apr 23 18:43:27 EEST 2022
     */
    int insert(Fund record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FUND
     *
     * @mbg.generated Sat Apr 23 18:43:27 EEST 2022
     */
    Fund selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FUND
     *
     * @mbg.generated Sat Apr 23 18:43:27 EEST 2022
     */
    List<Fund> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FUND
     *
     * @mbg.generated Sat Apr 23 18:43:27 EEST 2022
     */
    int updateByPrimaryKey(Fund record);
}