package com.crane.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crane.resource.dao.ResourceDao;
import com.crane.resource.exception.ResourceException;
import com.crane.resource.model.Resource;
import com.crane.resource.service.ResourceService;
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceDao resourceDao;
    @Override
    public List<Resource> getSelectedResourceListByRoleId(Integer roleId ) {
        
        return this.resourceDao.getSelectedResourceListByRoleId(roleId);
    }
    
    @Override
    public List<Resource> getSelectParentResourceListByRoleId(Integer roleId ) {
        
        return this.resourceDao.getSelectParentResourceListByRoleId(roleId);
    }
    
    @Override
    public List<Resource> getUnSelectedResourceListByRoleId(Integer roleId ) {
        return this.resourceDao.getUnSelectedResourceListByRoleId(roleId);
    }

    @Override
    public List<Resource> getParentId() {
        return this.resourceDao.getParentId();
    }

    @Override
    public List<Resource> getChildId() {
        return this.resourceDao.getChildId();
    }
    
    @Override
    public Resource load(Integer resource_id ) {
        return this.resourceDao.load(resource_id);
    }

    @Override
    public void del(Integer resource_id ) {
        try{
            this.resourceDao.del_role_mapping_resource(resource_id);
            this.resourceDao.del(resource_id);
        }catch(ResourceException e){
            e.printStackTrace();
            throw new ResourceException("ResourceServiceImpl类中的del()方法,删除失败");
        }
    }
    
    @Override
    public void getParentResource_id(Integer resource_id ) {
        int count = this.resourceDao.getParentResource_id(resource_id);
        if(count>0){
            throw new ResourceException("该父节点下存在子节点,禁止删除");
        }

    }
    
    @Override
    public void deleteParentNode(Integer resource_id ) {
        try{
            this.resourceDao.del(resource_id);
        }catch(ResourceException e){
            throw new ResourceException("ResourceServiceImpl类中的deleteParentNode()方法,删除失败");
        }
    }
    
    @Override
    public void checkParentName(Integer parent_id , String resource_name ) {
        Integer count = this.resourceDao.checkParentName(resource_name);
        if(count>0){
            throw new ResourceException("该资源名称已经存在,请输入其他名称");
        }
        
    }
    
    @Override
    public void updateResource(Resource resource) {
        try{
            this.resourceDao.updateResource(resource);
        }catch(ResourceException e){
            e.printStackTrace();
            throw new ResourceException("ResourceServiceImpl类中的updateResource()方法,更新失败");
        }
    }

    @Override
    public void addParentNode(Resource resource ) {
        int maxResource_id = this.resourceDao.selectMinResourceId(null);
        resource.setResource_id( maxResource_id+=-100);
        resource.setParent_id(-1);
        try{
            this.resourceDao.addParent(resource);
        }catch(ResourceException e){
            e.printStackTrace();
            throw new ResourceException("ResourceServiceImpl类中的addParentNode()方法,添加失败");
        }
    }

    @Override
    public void checkUrl(String url ) {
        Integer count = this.resourceDao.checkUrl(url);
        if(count>0){
            throw new ResourceException("该url已经存在");
        }
    }
    
    @Override
    public void checkResourceNameInparentId(String resource_id , Integer parent_id ) {
        Integer count = this.resourceDao.checkResourceNameInparentId(resource_id , parent_id);
        if(count>0){
            throw new ResourceException("该父节点下已经拥有此节点,请输入其他的名字");
        }
    }

    @Override
    public void addChlidNode(Resource resource ) {

        Integer maxResource_id =this.resourceDao.selectMinResourceId(resource.getParent_id());
        if(maxResource_id!=null){
            resource.setResource_id( maxResource_id+=-1);
            try{
                this.resourceDao.addChlidNode(resource);
            }catch(ResourceException e){
                e.printStackTrace();
                throw new ResourceException("ResourceServiceImpl类中的addChlid()方法,添加失败");
            }
        }else{
            resource.setResource_id(resource.getParent_id()+-1);
            try{
                this.resourceDao.addChlidNode(resource);
            }catch(ResourceException e){
                e.printStackTrace();
                throw new ResourceException("ResourceServiceImpl类中的addChlid()方法,添加失败");
            }
        }
    }

}
