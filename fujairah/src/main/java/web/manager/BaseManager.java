package web.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.IdGeneratorMapper;

/**
 * Created by yuhao.zx on 14-9-21.
 */
public class BaseManager {
    @Autowired
    private IdGeneratorMapper idGeneratorMapper;

    public Long genrate(Enum table){
        return idGeneratorMapper.generate(table.toString());
    }
}
