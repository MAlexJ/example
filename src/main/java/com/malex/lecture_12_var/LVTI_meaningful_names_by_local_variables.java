package com.malex.lecture_12_var;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.tools.DocumentationTool;
import javax.tools.ToolProvider;

/*
 * Meaningful names by local variables
 *
 * link: https://habr.com/ru/articles/438206/
 *
 * We usually focus on naming the correct class fields,
 * but we don’t give the same attention to the names of local variables.
 *
 * When we use var instead of writing explicit types, the compiler automatically defines them
 * and puts them in place of var.
 * But on the other hand, this makes it harder for people to read and understand the code,
 * as using var can make it more difficult to read and understand.
 */
public class LVTI_meaningful_names_by_local_variables {

  private final UserRepository userRepository = new UserRepository();

  /*
   * Case 1: HAVING
   * When using short names, together with var, the code becomes even less clear:
   */
  private boolean callDocumentationTaskOrigin() {
    DocumentationTool dtl = ToolProvider.getSystemDocumentationTool();
    DocumentationTool.DocumentationTask dtt = dtl.getTask(null, null, null, null, null, null);
    return dtt.call();
  }

  /*
   * Case 1: PREFER - The preferred option is:
   */
  private boolean callDocumentationTask() {
    var documentationTool = ToolProvider.getSystemDocumentationTool();
    var documentationTask = documentationTool.getTask(null, null, null, null, null, null);
    return documentationTask.call();
  }

  /*
   * Case 2: AVOID - Avoid naming variables like this:: u, p
   */
  private List<Product> fetchProductsORIGIN(long userId) {
    var u = userRepository.findById(userId);
    var p = u.getCart();
    return p;
  }

  /*
   * Case 2: PREFER - Use more meaningful names: user, productList
   */
  private List<Product> fetchProducts(long userId) {
    var user = userRepository.findById(userId);
    var productList = user.getCart();
    return productList;
  }

  /*
   * Case 3:  In an effort to give more clear names to local variables, do not fall into extremes:
   */
  private void method() {
    // AVOID
    var byteArrayOutputStream = new ByteArrayOutputStream();

    // PREFER
    var outputStream = new ByteArrayOutputStream();
    // or
    var outputStreamOfFoo = new ByteArrayOutputStream();
  }

  /*
   * Case 4: Avoid using var if the variable names do not contain enough information
   *
   *
   *
   */
  public void method_2(){
    // AVOID
    MemoryCacheImageInputStream inputStream = new MemoryCacheImageInputStream(InputStream.nullInputStream());

  }


  /*
   * Utils classes
   */
  private record Product() {}

  private record User() {
    public List<Product> getCart() {
      return Collections.emptyList();
    }
  }

  private record UserRepository() {
    public User findById(long userId) {
      return new User();
    }
  }
}
