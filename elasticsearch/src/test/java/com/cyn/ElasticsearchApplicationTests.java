package com.cyn;

import com.cyn.demo.ItemT;
import com.cyn.demo.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Test
	public void testCreateIndex() {
		elasticsearchTemplate.createIndex(ItemT.class);
	}


	/**
	 * @Description:定义新增方法
	 */
	@Test
	public void insert() {
		ItemT item = new ItemT(1L, "小米手机7", " 手机","小米", 3499.00, "123");
		itemRepository.save(item);
	}

	@Test
	public void testQueryAll(){
		// 查找所有
		//Iterable<Item> list = this.itemRepository.findAll();
		// 对某字段排序查找所有 Sort.by("price").descending() 降序
		// Sort.by("price").ascending():升序
		Iterable<ItemT> list = this.itemRepository.findAll(Sort.by("price").ascending());

		for (ItemT item:list){
			System.out.println(item.getBrand());
		}
	}


}
