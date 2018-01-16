package DieselSkrt.DRuneRunner;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

/**
 * Created by Shane on 15-1-2018.
 */
public abstract class Task<C extends ClientContext> extends ClientAccessor {

    protected final int[] PORTALID = {14846, 14841, 14844};
    protected final int[] ESSENCE = {7936, 1436};
    protected final int[] RUINSID = {14399, 14409, 14405};
    protected final int[] craftAltar = {14902,14900,14897};

    public Task(C ctx){
        super(ctx);
    }

    public abstract boolean activate();
    public abstract void execute();

    public boolean portalNear(){
        try{
         if( ctx.objects.select().id(PORTALID).isEmpty()){
             return false;
         }else{
             return true;
         }
        }catch(Exception e){
            System.out.println("Exception thrown at portalnear");
        }
        return false;
    }
    public boolean essenceInInvent(){
        try{
            if(ctx.inventory.select().id(ESSENCE).isEmpty()){
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            System.out.println("Exception thrown at essencininvent");
        }
        return false;
    }
    public boolean ruinsNear(){
        try{
            if(ctx.objects.select().id(RUINSID).isEmpty()){
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            System.out.println("Exception thrown at ruinsnear");
        }
        return false;
    }
    public boolean crafterNear(){
        try{
            if(ctx.players.name(DRuneRunner.CRAFTER_USERNAME).isEmpty()){
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            System.out.println("Exception thrown at crafterNear");
        }
        return false;
    }
    public boolean craftAltarNear(){
        try{
            if(ctx.objects.select().id(craftAltar).isEmpty()){
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            System.out.println("Exception thrown at craftaltarnear");
        }
        return false;
    }
}
