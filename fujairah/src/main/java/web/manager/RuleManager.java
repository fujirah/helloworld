package web.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.common.constant.TableName;
import web.common.exception.ManagerException;
import web.dao.RuleMapper;
import web.entity.Rule;

import java.util.List;

/**
 * Created by yuhao.zx on 14-9-20.
 */
@Service
public class RuleManager extends BaseManager{
    @Autowired
    private RuleMapper ruleMapper;

    public List<Rule> getRuleList(Rule rule){
        return ruleMapper.selectList(rule);
    }

    @Transactional
    public void insert(Rule rule){
        if(rule==null)
            throw new ManagerException("param null");
        rule.setId(genrate(TableName.rule));
        ruleMapper.insert(rule);
    }

    public Integer getCount(Rule rule){
        return ruleMapper.selectCount(rule);
    }

    public void delete(Long ruleId){
        Rule rule = new Rule();
        rule.setId(ruleId);
        rule.setDeleted(1);
        ruleMapper.updateByPrimaryKeySelective(rule);
    }

    public  Rule getRuleById(Long ruleId){
        Rule rule = new Rule();
        rule.setPagging(false);
        rule.setId(ruleId);
        List<Rule> list = getRuleList(rule);
        if(list == null || list.isEmpty())
            return null;
        return list.get(0);
    }
}
