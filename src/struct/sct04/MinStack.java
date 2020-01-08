package struct.sct04;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：leeCodeTran
 * 类名：MinStack
 * 描述：
 *
 * @author Administrator
 * 创建时间：2019-12-31 16:12
 **/
public class MinStack {
    private int min;

    private List<Integer> data;
    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        if (data.isEmpty()){
            min = x;
        }
        min = Math.min(min,x);
        data.add(x);
    }

    public void pop() {
        if (!data.isEmpty()){
            if (top() == min){ //减少非必要的重排序
                data.remove(data.size() -1);
                List<Integer> fix = new ArrayList<>(); // 不能直接等于data，会发生引用的数据被排序
                fix.addAll(data);
                if (!fix.isEmpty()){
                    fix.sort(Integer::compareTo);
                    min = fix.get(0);
                }else{
                    min = 0;
                }

            }else{
                data.remove(data.size() -1);
            }

        }

    }

    public int top() {
        return data.get(data.size()-1);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
