package com.example.myapplication.algorithm.stack

import java.util.*
import kotlin.collections.HashMap

class SolutionFor20 {

/**    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。*/

    companion object{
     //基本思路就是把左括号存在栈中，如果碰见右括号就从栈顶取出左括号看是不是对应的左括号

    /**
     * 时间复杂度是O（n）遍历整个string
     * 空间复杂度要算hash表和链表的长度
     *
     * 1.左括号就入栈
     * 2、右括号
     *      (1)当前栈是否为空
     *      (2)当前栈顶是否为对应左括号
     *    不满足就把出栈
     * */
    fun isValidString( s : String) : Boolean{
        var strLength = s.length

        if(strLength%2 == 1) return false
        //把左右括号存在map里，这样方便查询

        var bracketPair:HashMap<Char,Char> = hashMapOf(')' to '(' ,']' to '[' , '}' to '{')

        var stack: LinkedList<Char> = LinkedList()
        for (i in 0..strLength){
            var singleChar : Char = s[i]

            //判断当前字符是不是右括号
            if(bracketPair.containsKey(singleChar)){
                //如果有右括号，而且栈里面为空(理论上应该至少有一个左括号)
                //或者这时候栈顶  不是对应的左括号
                if(stack.isEmpty() || stack.peek() != bracketPair[singleChar]){
                    //判断栈是不是为空 或者  栈顶的元素是不是等于（右括号）(栈里面理论上只能存左括号，如果存在右括号就无效)
                    return false
                }
                //当前栈 中  有对应的 左括号  就把这个左括号出栈出栈
                stack.pop()
            }else{
                //如果栈中是左括号就入栈
                stack.push(singleChar)
            }
        }

        return stack.isEmpty()
    }

    }
}