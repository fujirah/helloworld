package web.entity;

public class Rule extends BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.id
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.name
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.object_type
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    private Integer objectType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.label
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    private String label;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.attr
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    private String attr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule.deleted
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    private Integer deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.id
     *
     * @return the value of rule.id
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.id
     *
     * @param id the value for rule.id
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.name
     *
     * @return the value of rule.name
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.name
     *
     * @param name the value for rule.name
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.object_type
     *
     * @return the value of rule.object_type
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public Integer getObjectType() {
        return objectType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.object_type
     *
     * @param objectType the value for rule.object_type
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public void setObjectType(Integer objectType) {
        this.objectType = objectType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.label
     *
     * @return the value of rule.label
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public String getLabel() {
        return label;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.label
     *
     * @param label the value for rule.label
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.attr
     *
     * @return the value of rule.attr
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public String getAttr() {
        return attr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.attr
     *
     * @param attr the value for rule.attr
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public void setAttr(String attr) {
        this.attr = attr == null ? null : attr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule.deleted
     *
     * @return the value of rule.deleted
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule.deleted
     *
     * @param deleted the value for rule.deleted
     *
     * @mbggenerated Sat Sep 20 16:51:12 CST 2014
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}