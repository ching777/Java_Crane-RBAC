package com.crane.resource.service;

import java.util.List;

import com.crane.resource.model.Resource;

public interface ResourceService {
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
    public List<Resource> getUnSelectedResourceListByRoleId(Integer roleId);
    
    public List<Resource> getParentId();
    public List<Resource> getChildId();

    public Resource load(Integer resource_id);
    
    public void del(Integer resource_id);
    public void deleteParentNode(Integer resource_id);
    //检查父节点下面是否存在子节点
    public void getParentResource_id(Integer resource_id);
    //查看节点url
    public void checkUrl(String url);
    //检查父节点名字是否重复
    public void checkParentName(Integer parent_id,String resource_name);
    //  查看父节点下的子节点
    public  void checkResourceNameInparentId( String resource_id , Integer parent_id);
    
    //修改父节点名称/图标
    public void updateResource(Resource resource );
    //添加父节点
    public void addParentNode(Resource Resource);
    //添加子节点
    public void addChlidNode(Resource resource);

}
