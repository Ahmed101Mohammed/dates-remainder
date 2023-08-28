# It's an emigane conversation between me (as developer) and me (as client). [Note: I'm not crazy man]. 
- Client:
> I want:
> - The ablity to see my own dates in the day when I open the application.
> - The ablity to add data with a task, to let the app remind me when I need.

## Part one of the conversation. (The dates form presentation).
- Developer:
> Ok, I need to know how you want the aplication to present your data? you want it:
> - Present like: 1- task1
>                 2- task2
>                 etc.
> - Present like previous with out numbers.

- Client:
> Ok, I want it like, we can say date of the curent day then tasks in like you suggest wihtout numbers.

- Developer:
> Ok you want it like this;
> - Hi 'User' to day is : yyyy/mm/dd
> - These is your tasks to day:
>   - task1
>   - task2
>   - etc.

- Client:
> Ok, it's great but without years.

- Deveeloper:
> Ok this is result:
> - Hi 'User' to day is : mm/dd
> - These is your tasks to day:
>   - task1
>   - task2
>   - etc.

## Part two of the conversation. (User Add new Task)
- Developer:
> Ok how you want be the first window of the app?
> Do you have sign board?!

- Client:
> No, I don't want any signing or registering. I want it's local for one accout for one device. when I open I have my own dates quicly.
> I want the window that we talken about befor to be the first view.

- Developer:
> Ok, that's main that your application will have just one user for one device, with authantication you can had multibel users in one devie.

- Client: 
> I know that.

- Developer:
> Ok, how do you want the user to add his new tasks with dates?
> We can add a line after presentation of day tasks, for a adding new tasks.
> like this:
> - Hi to day is : mm/dd
> - These is your tasks to day:
>   - task1
>   - task2
>   - etc.
> ______________
> - You can Add new task with a date in this form: yyyy/mm/dd:task: (client data)

- Client:
> It's look too long, I want it shorter.

- Developer:
> What about this:
> - Hi to day is : mm/dd
> - These is your tasks to day:
>   - task1
>   - task2
>   - etc.
> ______________
> - You can Add new task with a date in this form: yyyy/mm/dd:task.
> - Add your new task: (user data)

- Client:
> Ok, it's good. but I think the form of data is complicated we can split it for more steps?


- Developer:
> sure we can. see this:
> - Hi to day is : mm/dd
> - These is your tasks to day:
>   - task1
>   - task2
>   - etc.
> ______________
> - You can Add new task:
> - Add the date of you new task (yyyy/mm/dd): (user data)
> - Add your new task: (user data)

- Client:
> Ok, it's better.

## Part three of the conversation. (User adding wrong data).

- Developer:
> If your user input wrong data like date in other formate, what do you want app to do?!
> - You want wrong massage and present the input faild again?!
> - Or wrong massage and quit from the app.
> - Or tell me if you have special idea.

- Client:
> I think the first choice is good.

- Developer:
> Ok look to this example:
> - Hi to day is : mm/dd
> - These is your tasks to day:
>   - task1
>   - task2
>   - etc.
> ______________
> - You can Add new task:
> - Add the date of you new task (yyyy/mm/dd): !WRONG DATA
> - Plase add real date in right formate: yyyy/mm/dd like: 2023/8/28
> - Add the date of you new task (yyyy/mm/dd): (user data)
> - Add your new task: (user data)

- Client:
> Ok I think it's good.

- Developer:
> Ok what if your client add new task and before click enter he want to stop.
> We can give him the aplity to quit from the app.

- Client:
> No I don't him/her quit.

- Developer:
> Ok I think we can let him to add specfic sentence in any step. like:
> - Hi to day is : mm/dd
> - These is your tasks to day:
>   - task1
>   - task2
>   - etc.
> ______________
> - You can Add new task (In any step print "no" to avoid adding the task):
> - Add the date of you new task (yyyy/mm/dd): (user data)
> - Add your new task: (user data)

- Client:
> Ok I like it, it's sample.

## Part four of the conversation. (User quiting)
- Developer:
> Ok we need to add a way to quit from the app. it will be with some thing like: Ctrl + Z keys or quit word.

- Client:
> Not problem, choose what you think it's good for quiting.

- Developer:
> Ok This is final result:
> Ok I think we can let him to add specfic sentence in any step. like:
> sure we can. see this:
> - Hi to day is : mm/dd
> - These is your tasks to day:
>   - task1
>   - task2
>   - etc.
> ______________
> - To quite form app (Quite constructors)
> - You can Add new task (In any step print "no" to avoid adding the task):
> - Add the date of you new task (yyyy/mm/dd): (user data)
> - Add your new task: (user data)

- Client:
> Yeah, this what I want.

- Developer:
> Note that your app will be used by one user for one device.
> The user will not have the ablity to edit or remove any task for any date.
> Your app simple but have many limitations.

- Client:
> This is my goal. I want this to encourage my users to don't dalay any thing.
> They can see these tasks and ignore, but they shouldn't remove it.

- Developer:
> Ok for now. if I need any answer I will talk you. And if you change your requirments you can talk me.