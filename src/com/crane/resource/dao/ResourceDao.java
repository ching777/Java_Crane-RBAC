package com.crane.resource.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.crane.resource.model.Resource;

public interface ResourceDao {
    /**
     * @param： 通过角色获取所有的节点资源
     */
    public List<Resource> getSelectedResourceListByRoleId(Integer roleId);
    /**
     * @param： 通过角色获取父节点资源
     */
    public List<Resource> getSelectParentResourceListByRoleId(Integer roleId);
    
    /**
     * @param： 通过角色获取所有的未拥有的节点资源 不包含-1
     */
    public List<Resource> getUnSelectedResourceListByRoleId(@Param("roleId") Integer roleId);
    
    //删除
    public void deleteRoleMappingResource(Integer role_id);
    
    public void insertRoleMappingResource(@Param("role_id") Integer role_id,@Param("resources") Integer[] resources);
    
    //获取子父节点
    public List<Resource> getParentId();
    public List<Resource> getChildId();

    public Resource load(Integer resource_id );
    
    //删除子节点 更新中间表 or 删除父节点
    public void del(Integer resource_id);
    public void del_role_mapping_resource(Integer resource_id);
    //检查父节点下面是否存在子节点
    public int getParentResource_id(Integer resource_id);
    //修改父节点名称/图标
    public void updateResource(Resource resource);
    //查看父节点是否重复
    public Integer checkParentName(String resource_name);
    //查看节点url
    public Integer checkUrl(String url);
    //  查看父节点下的子节点
    public  int checkResourceNameInparentId( String resource_id , Integer parent_id);
    //查询最大的 resourceId
    public Integer selectMinResourceId(@Param("resource_id") Integer resource_id);
    public void addParent(Resource resource);
    public void addChlidNode(Resource resource);

}
