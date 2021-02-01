package com.youkeda.app.control;

import com.youkeda.app.model.MatchData;
import com.youkeda.app.model.Result;
import com.youkeda.app.service.MatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @date 2020/6/8, 周一
 */
@RequestMapping(value = "/matchdata")
@Controller
public class MatchDataController {

    @Autowired
    private MatchDataService matchDataService;

    @PostMapping("/add")
    @ResponseBody
    public Result<Integer> add(@RequestBody MatchData matchData) {

        Result<Integer> result = new Result<>();
        if (matchData.getId() != null) {
            return result;
        }

        Integer addNum = matchDataService.add(matchData);
        result.setData(addNum);
        if (addNum > 0) {
            result.setSuccess(true);
        }

        return result;

    }

}
