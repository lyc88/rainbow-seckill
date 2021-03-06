package com.jhon.rain.dao;

import com.jhon.rain.entity.SecKillGoods;
import com.jhon.rain.pojo.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>功能描述</br>商品数据接入层</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-seckill
 * @date 2018/5/16 19:38
 */
@Mapper
public interface GoodsDAO {

  /**
   * <pre>查询商品</pre>
   *
   * @return
   */
  @Select("select g.*,sg.stock_count,sg.start_date,sg.end_date,sg.miaosha_price from t_seckill_goods sg left join t_goods g on sg.goods_id = g.id")
  List<GoodsVO> listGoodsVO();

  /**
   * <pre>查询商品详情</pre>
   *
   * @param goodsId
   * @return
   */
  @Select("select g.*,sg.stock_count,sg.start_date,sg.end_date,sg.miaosha_price from t_seckill_goods sg left join t_goods g on sg.goods_id = g.id where g.id=#{goodsId}")
  GoodsVO getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

  /**
   * <pre>减小库存</pre>
   *
   * @param secKillGoods
   * @return
   */
  @Update("update t_seckill_goods set stock_count = stock_count - 1 where goods_id = #{goodsId} and stock_count > 0")
  int reduceStock(SecKillGoods secKillGoods);

  /**
   * <pre>重置</pre>
   *
   * @param secKillGoods
   * @return
   */
  @Update("update t_seckill_goods set stock_count = #{stockCount} where goods_id = #{goodsId}")
  int resetStock(SecKillGoods secKillGoods);
}
