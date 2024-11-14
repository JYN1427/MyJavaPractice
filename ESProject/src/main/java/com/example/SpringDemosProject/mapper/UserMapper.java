package com.example.SpringDemosProject.mapper;

import com.example.SpringDemosProject.models.es.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 这些方法的名称遵循一种命名约定，这种约定将方法名中的关键词（如 findBy、Like、IgnoreCase 等）与实体类（User）的属性名相关联。
 * 这样，Spring Data Elasticsearch 可以根据方法名自动生成相应的查询。
 * 在Spring Data Elasticsearch中，查询方法的命名约定依赖于一些关键词和命名规范，这些关键词用于描述要执行的查询操作。以下是一些常见的关键词和它们的含义：
 *     findBy：指定查询的条件的前缀，后面通常跟随实体类的属性名。例如，findByUsername 表示要根据用户名进行查询。
 *     Like：用于模糊查询，通常与属性名一起使用。例如，findByUsernameLike 表示要进行用户名的模糊查询。
 *     IgnoreCase：用于不区分大小写的查询，通常与属性名一起使用。例如，findByUsernameIgnoreCase 表示不区分大小写地查询用户名。
 *     Containing：用于包含查询，通常与属性名一起使用。例如，findByUsernameContaining 表示包含指定内容的查询。
 *     And 和 Or：用于构建复合查询条件。例如，findByUsernameAndAge 表示根据用户名和年龄进行查询。
 *     OrderBy：用于指定结果的排序方式。例如，findByAgeOrderByUsernameDesc 表示根据年龄查询并按用户名降序排序。
 *     Page 和 Iterable：用于指定查询结果的返回类型。例如，Page<User> 表示返回分页结果，Iterable<User> 表示返回一个列表。
 *     其他属性名：您可以根据实体类的属性名来定义查询条件。例如，如果实体类有一个属性为 email，您可以编写 findByEmail 方法来根据邮箱进行查询。
 * */
public interface UserMapper
//        extends ElasticsearchRepository<User, String>
{

    /**
     *自定义查询
     * */
    List<User> findByAddressLikeIgnoreCaseOrderByAgeDesc(String address);

    Page<User> findByUsernameContaining(String username, Pageable page);

    User findByAge(Integer age);

    List<User> findByGender(String gender);

    long count();

    Boolean existsById();

}
