package Data_Structure.atgao.linkedlist;

/**
 * @ClassName: SingleLinkedList
 * @Description: TODO
 * @Author: 高举
 * @Date: 2021/12/15 20:59
 * @URL：https://github.com/GaoHaiNB
 */
public class SingleLinkedListDemo {
    public static void main(String[] args){
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        //显示
        singleLinkedList.list();
    }
}
class SingleLinkedList{
    //初始化一个头节点,不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单项列表
    //思路，当不考虑顺序时1.找到当前链表的最后节点 2.将这个节点的next指向下一个节点
    public void add(HeroNode heroNode){
       //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp=head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if(temp.next==null){
                break;
            }
            //如果没有找到，就将temp后移动
            temp = temp.next;
        }
        //当退出while时，temp就指向了链表的最后,然后指向新的节点就可
        temp.next=heroNode;
    }
    //显示链表[遍历]
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
       //因为头节点不能动，因此需要一个辅助变量遍历
        HeroNode temp = head.next;
        while (true){
            //判断链表是否到了最后一个节点
            if(temp == null){
              break;
            }
             //输出节点的信息
            System.out.println(temp.toString());
            //将temp后移，一定要后移，不然全是第一个
            temp = temp.next;
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}