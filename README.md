# Refatoramento

### Observações Iniciais
Este trabalho é o refatoramento do projeto **'Folha de Pagamento'**, cuja autoria pertence a [@BrunaDamaris](https://github.com/BrunaDamaris)

[Link para o código original](https://github.com/BrunaDamaris/Re-Folha-de-Pagamento)

# Padrões de projeto implementados: 

## Command

   Este padrão está implementado em todas as classes do pacote "command". 
   
   - [X] [command package](https://github.com/ferreiraluana/Refactor2/tree/master/src/command)
   
   Exemplo:
   ```java
   package command;

   import folhadepagamento.Timecard;

   public class TimecardCommand implements MainCommand{
	   public void execute() {
	   	Timecard timecard = new Timecard();
	   	timecard.card();
	   }
   }
   
   ```
    
## Strategy

   Este padrão está implementado dentro do pacote "edit", nas classes 'EditStrategy.java' e 'EditTypeStrategy.java'. 
   
  - [X] [EditStrategy.java](https://github.com/ferreiraluana/Refactor2/blob/master/src/edit/EditStrategy.java)
  - [X] [EditTypeStrategy.java](https://github.com/ferreiraluana/Refactor2/blob/master/src/edit/EditTypeStrategy.java)
  
   Exemplo:
   ```java
   package edit;

   import java.util.Map;
   import java.util.Scanner;

   import employee.Employees;

   public interface EditStrategy {
	   public void change (Map<Integer,Employees> employee,int currentid,Scanner input);
   }
   
   ```
     
## Singleton

   Este padrão está implementado dentro do pacote "syndicate", na classe 'Singleton.java'.
   
   - [X] [Singleton.java](https://github.com/ferreiraluana/Refactor2/blob/master/src/syndicate/Singleton.java)
     
   Exemplo:
   ```java
   package syndicate;

   public final class Singleton {
	private static SyndicateCG synd;
	
	public static SyndicateCG getInstance() {
		if(synd == null) {
			synd = new SyndicateCG();
		}		
		return synd;
        }
   }
   
  ```
