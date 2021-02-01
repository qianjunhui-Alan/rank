package com.youkeda.app.control;

import com.mysql.cj.log.ProfilerEventImpl;
import com.youkeda.app.model.Result;
import com.youkeda.app.model.User;
import com.youkeda.app.service.MatchDataService;
import com.youkeda.app.service.PersonalRecordService;
import com.youkeda.app.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @date 2020/6/6, 周六
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MatchDataService matchDataService;

    @Autowired
    private PersonalRecordService personalRecordService;

    @PostMapping("/add")
    @ResponseBody
    public Result<Integer> addUser(@RequestBody User user) {

        Result<Integer> result = new Result<>();
        if (user == null){
            return result;
        }
        Integer save = userService.save(user);
        if (save > 0){
            result.setData(save);
            result.setSuccess(true);
        }
        return result;

    }

    @GetMapping("/delete")
    @ResponseBody
    public Result<Integer> deleteUser(@RequestParam("userId") Long userId){
        Result<Integer> result = new Result<>();
        if (userId == null){
            result.setSuccess(false);
            return result;
        }
        User user = new User();
        user.setId(userId);
        user.setValid(0);
        userService.save(user);
        personalRecordService.delete(userId);
        result.setData(matchDataService.delete(userId));
        result.setSuccess(true);
        result.setMessage("删除成功");
        return result;
    }


}
