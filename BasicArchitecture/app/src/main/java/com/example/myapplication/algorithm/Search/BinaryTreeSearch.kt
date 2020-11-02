package com.example.myapplication.algorithm.Search
//二叉查找树
class BinaryTreeSearch {
    /**
     *二叉树查找树   任一节点的左子树的每个节点都小于它    右子树都大于它
     * */
    //查找
    fun treeSearch(data: Int,node:Node) :Node?{
        if(node == null) return node

        var treeNode = node
        while (treeNode != null){
            if(data < treeNode.data) treeNode = treeNode.left
            else if(data> treeNode.data) treeNode = treeNode.right
            else{
                return treeNode
            }
        }
        return null

    }

    //插入
    fun treeInsert(data: Int, node: Node){
        var treeNode = node
        if(node == null){
            treeNode = Node(data)
            return
        }
        while (treeNode !=null){
            if(data>treeNode.data){
                if(treeNode.right ==null){
                    treeNode.right = Node(data)
                    return
                }
                treeNode = treeNode.right
            }else{
                if(treeNode.left ==null){
                    treeNode.left = Node(data)
                    return
                }
                treeNode = treeNode.left
            }
        }
    }

    fun deleteNode(){
        //1.如果目标节点没有子节点，那直接把父节点指向null
        //2.如果目标节点有左节点或者右节点，那就把父节点指向对应的结点
        //3.如果目标节点既有左节点又有右节点，那就可以从目标节点的右子树中找出最小的结点顶上
    }
}