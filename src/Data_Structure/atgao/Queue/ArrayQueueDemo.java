package Data_Structure.atgao.Queue;

import java.util.Scanner;

/**
 * @ClassName: ArrayQueueDemo
 * @Description: TODO
 * @Author: 高举
 * @Date: 2021/12/15 8:19
 * @URL：https://github.com/GaoHaiNB
 */
public class ArrayQueueDemo {
    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key=' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (true){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列头部数据");
            key=scanner.next().charAt(0);//接受一个字符串
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value=scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res=arrayQueue.getQueue();
                        System.out.printf("取出的数据为：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                   try {
                       int res= arrayQueue.headQueue();
                       System.out.printf("头数据为：%d\n",res);
                   }catch (Exception e){
                       System.out.println(e.getMessage());
                   }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
            System.out.println("程序退出");
        }
    }
}
class  ArrayQueue{
    private int maxSize; //表示数组最大的容量
    private int front;  //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用于存放队列，模拟数据

    //初始化队列
    public ArrayQueue (int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1; //指向队列头部的前一个位置
        rear=-1;  //指向队列尾部的位置(也就是指向最后一个数据)
    }
    //判断队列是否为满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //先判断队列是否为满
        if(isFull()){
            System.out.println("队列是满的，不能加入数据.......");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //获取队列的数据(出队列)
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据......");
        }
        front++;
        return arr[front];
    }
    //显示所有队列
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据，不能显示....");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列头
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取头数据......");
        }
        return arr[front+1];
    }
}