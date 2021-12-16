package com.dayup.dreamhub.controller;


import com.dayup.dreamhub.entity.Web;
import com.dayup.dreamhub.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dreamice
 * @since 2021-11-18
 */
@RestController
@RequestMapping("/web")
public class WebController {
    @Autowired
    WebService webService;

    /*
    * 查询
    * */
    @GetMapping("/list")
    public Object index(){
        return webService.list();
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public Object getById(@PathVariable(name = "id") String id){
        return webService.getById(id);
    }

    /**
     * 添加web
     * @param web
     * @return
     */
    @PostMapping("/add")
    public boolean add(@RequestBody  Web web){
        return webService.save(web);
    }

    /**
     * 更新网站
     * @param web
     * @return
     */
    @PostMapping("/update")
    public boolean updateById(@RequestBody  Web web){
        return webService.updateById(web);
    }

    /**
     * 删除网站
     * @param id
     * @return
     */
    @GetMapping("remove/{id}")
    public boolean delete(@PathVariable(name = "id") String id){
        return webService.removeById(id);
    }
}
