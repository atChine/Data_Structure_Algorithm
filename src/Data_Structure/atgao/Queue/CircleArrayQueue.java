package Data_Structure.atgao.Queue;

import java.util.Scanner;

/**
 * @ClassName: CirleArrayQueue
 * @Description: TODO
 * @Author: 高举
 * @Date: 2021/12/15 19:39
 * @URL：https://github.com/GaoHaiNB
 */
public class CircleArrayQueue {
    public static void main(String[] args){
        System.out.println("测试数组循环队列.......");
        CircleArray circleArray = new CircleArray(4);
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
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value=scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res=circleArray.getQueue();
                        System.out.printf("取出的数据为：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res= circleArray.headQueue();
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
class CircleArray{
    private int maxSize; //表示数组最大的容量
    private int front;  //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用于存放队列，模拟数据
    //初始化队列
    public CircleArray(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=0; //指向队列第一个元素
        rear=0; //指向队列最后一个元素
    }
    //判断队列是否满了
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据
    public void addQueue(int n){
        if(isEmpty()){
            System.out.println("队列满了，不能再加le");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }
    //获取队列的数据(出队列)
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据......");
        }
        int value=arr[front];
        front=(front+1) % maxSize;
        return  value;
    }
    //显示队列数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据，不能显示....");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    //求出当前队列的有效数据
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    //显示队列头
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取头数据......");
        }
        return arr[front];
    }
}