package com.youkeda.app.control;

import com.youkeda.app.model.PersonalRecord;
import com.youkeda.app.model.Result;
import com.youkeda.app.service.PersonalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * @date 2020/6/9, 周二
 */
@Controller
@RequestMapping("/record")
public class PersonalRecordController {

    @Autowired
    private PersonalRecordService personalRecordService;

    @GetMapping("/rank/limit")
    @ResponseBody
    public Result<List<PersonalRecord>> queryLimitRank(@RequestParam(value = "limit") Long limit) {

        Result<List<PersonalRecord>> result = new Result<>();
        result.setData(personalRecordService.queryLimit(limit));
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/user")
    @ResponseBody
    public Result<PersonalRecord> findByUserId(@RequestParam(value = "userid") Long userId) {

        Result<PersonalRecord> result = new Result<>();
        result.setData(personalRecordService.findByUserId(userId));
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/user/index")
    @ResponseBody
    public Result<Long> getRankIndex(@RequestParam(value = "userid") Long userId) {

        Result<Long> result = new Result<>();
        result.setData(personalRecordService.getRankIndex(userId));
        result.setSuccess(true);
        return result;
    }

}
