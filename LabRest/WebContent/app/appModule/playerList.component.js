angular.module('appModule')   
    .component('playerList', {      	//getting the appModule from APP.MODULE.JS and assigning it a component
    	
    	templateUrl: 'app/appModule/playerList.component.html',
    	controller: function(ballplayerService)  {
    		var vm = this;
    		
    		vm.selected=null;
    		
    		vm.showPlayerEditForm = true;
    		

    		//READ
    		ballplayerService.index().then(function(response) {
				vm.ballplayers =response.data;			
			})	
			
	   
		
		//CREATE
		vm.createBallplayer = function(player) {
			ballplayerService.create(player).then(function(response) {
				vm.players = response.data;
			
			})
		
		};
			
		//UPDATE
		vm.editBallplayer = function(id,player) {
			ballplayerService.update(id, player).then(function(response) {
				vm.editedBallplayer = response.data;
				console.log("did i EDIT a ballplayer?");     //check to see if i am logging this event in Chrome
			})
		}
		
		//DELETE
		vm.destroyBallplayer = function(id)  {
			ballplayerService.destroy(id);
		}
		
		 //var agentFees = null;
		
		//random functionality that returns total of fees paid to sports agent based on % of aggregate TOTAL salaries
		vm.costPaidtoAgents = function() {
			ballplayerService.index().then(function(response) {
				vm.ballplayers  = response.data;
				vm.agentFees = vm.ballplayers.reduce(function(a, vm.ballplayers.salary)  {
					return a + value;
				}, 0)  * 0.05;  //average 5 percent commission fee, like Mark Steinberg or Scott Boras
				//vm.agentFees = vm.ballplayers.length * 0.05;
				return vm.agentFees;
			})
		}	
		
		vm.agentFees = vm.costPaidtoAgents();
		
		vm.oneBallplayer = {};
		
		vm.showBallplayer = function(id) {
			ballplayerService.show(id).then(function(response) {
				vm.oneBallplayer  = response.data;
				
			});
		}

    	    
    		vm.log = function(str) {
    			console.log(str);
    		}
    	    
    		vm.getNumBallplayers = function() {
    	        return vm.ballplayers.length;
    	      }
    		
    		
    		
    	    //modify the function to add a product 
    	    //vm.addProduct = function(todoproduct)  {
    	    	//todoService.create(todoproduct);
    	    	//vm.todos=todoService.index();
    	    
    	    //}
    		
    		vm.generateId = function() {
  			  return vm.ballplayers[vm.ballplayers.length-1].id + 1;
  			}
    		
    		
    		
    		
    	
    		
    		
    		
    		
    	

       		
       		vm.displayPlayer = function(player) {
       			console.log('Hello Kris');
       			vm.selected=player;
       		}
       		
       		vm.displayTable =function() {
                 vm.selected=null;
       		}
       		
       		vm.setEditTodoPlayer=function() {
       			vm.editPlayer = angular.copy(vm.selected);
     
       		}
       		
       		vm.cancelButtonNullFields = function()  {
       		       vm.editPlayer=null;
           	}
       		
       		

 

    },
    controllerAs:  'vm'
     
    })
    
    
        		/**
    		function() {
    		var vm = this; 		
    		vm.todos = [
   		
   		
   		
   		name : 'Kobe Bryant',
    			    salary : 25000000,
    			    pointspergame : 25.0,
    			    imageUrl :	"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1Tb9iQdNQSr1OYztRlmZ7qc4Z0ivutjvrc2TLpL-jzmeh_4Fj"
    		]  		
    	}
    	
    	
    	 <img ng-src="{{book.imgUrl}}"/>
    		 */