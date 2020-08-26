
package javaapplication14;

  public class CarQueue {
    private Node frontNode;
    private Node backNode;
    
    public CarQueue()
    {
        frontNode=null;
        backNode=null;
    }
    public void CarenQueue(String newEntry)
    {
        if((frontNode==null)&&(backNode==null))
        {
            Node newNode = new Node(newEntry,null);
            frontNode=newNode;
            backNode=newNode;
        }
        else
        {
            Node newNode = new Node(newEntry,null);
            backNode.next=newNode;
            backNode=newNode;
        }
    }
    
    public void Carprint()
    {
        Node temp=frontNode;
        while(temp!=null)
        {
            System.out.println("Enqueued : "+temp.name);
            temp=temp.next;
        }
    }
    
    public String Cardequeue()
    {
        String result=null;
        if(!CarisEmpty())
        {
            result = frontNode.name;
            if(frontNode==backNode)//one person queue
            {
                frontNode=null;
                backNode=null;
            }
            else//more than one person in queue
            {
                frontNode=frontNode.next;//like i++
            }
            
        }
        else
            System.out.println("queue is empty cannot dequeue");
        return result;
    }
    
    public boolean CarisEmpty()
    {
        if((frontNode==null)&& (backNode==null))
            return true;
        else
            return false;
               
    }
    
    
    public String CargetFront()
    {
        String result=null;
        if(!CarisEmpty())
        {
            result = frontNode.name;
        }
        else
            System.out.println("queue is empty cannot getfront");
        return result;
    }
    
    public void Carclear()
    {
        frontNode=null;
        backNode=null;
    }
    
    
    
    
    
    
}
