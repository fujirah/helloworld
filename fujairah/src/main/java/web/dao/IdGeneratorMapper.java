package web.dao;

/**
 * Created by yuhao.zx on 14-9-21.
 */
public interface IdGeneratorMapper {
    Long generate(String tableName);
}
