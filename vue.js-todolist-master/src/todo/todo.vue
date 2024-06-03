<!--todo.vue-->
<template>
    <section class="real-app">
      <div class="header">
        <span class="username">{{ username }}</span>
      </div>
        <input 
            type="text" 
            class="add-input"
            autofocus="autofocus"
            placeholder="What would u do next?"
            @keyup.enter="addTodo"
            v-model="newTodoTitle"
        >
      <div class="priority-container">
        <span class="priority-label">What's your priority?</span>
        <select v-model="newTodoPriority" class="priority-select">
          <option value="1">High</option>
          <option value="2">Medium</option>
          <option value="3">Low</option>
        </select>
      </div>
        <Item  
            v-for="todo in filterTodos"
            :todo="todo"
            :key="todo.id"
            @del="deleteTodo"
            @toggle-complete="updateTodoCompletion"
            v-if="todos.length > 0"
        />
        <Tabs
            :filter="filter"
            :todos="todos"
            @toggle="toggleFilter"
            @clearAll="clearAllCompletedTodo"
        />
    </section>
</template>

<script>
import Item from './item.vue';
import Tabs from './tabs.vue';
import axios from "axios";

export default {
    data() {
        return {
            todos: [],
            filter: 'all',
          newTodoTitle: '',
          newTodoPriority: 1,
          username: ''
        }
    },
    components: {
        Item,
        Tabs,
    },
    computed: {
        filterTodos() {
          let filteredTodos = this.todos;
          if (this.filter !== 'all') {
            const filterCompleted = this.filter === 'completed';
            filteredTodos = this.todos.filter(todo => todo.completed === filterCompleted);
          }
          return filteredTodos.sort((a, b) => a.priority - b.priority); //
        }
    },
  created() {
    this.$watch(
        () => sessionStorage.getItem('name'),
        (newName, oldName) => {
          if (newName !== oldName) {
            this.fetchTodoItems();
          }
        }
    );
    this.username = sessionStorage.getItem('name') || 'Guest';
  },
    methods: {
        addTodo(e) {
          const name = sessionStorage.getItem('name');
          if (!name) {
            console.error('Username not found in Session Storage');
            return;
          }
          const todoData = {
            // title: e.target.value,
            title: this.newTodoTitle,
            description: '',
            completed: false,
            name: name,
            priority: this.newTodoPriority // 使用绑定的优先级
          };
          axios.post('http://localhost:8081/todo/add', todoData)
              .then(response => {
                this.fetchTodoItems();
                this.newTodoTitle = ''; // 清空输入框
                this.newTodoPriority = 1; // 重置优先级选择
              })
              .catch(error => {
                console.error('Failed to add todo item:', error);
              });
          e.target.value = '';
        },

        deleteTodo(id) {
            this.todos.splice(this.todos.findIndex(todo => id === todo.id), 1);
          axios.delete(`http://localhost:8081/todo/delete`, {
            params: { id: id }
          })
              .then(response => {
                console.log('Todo item deleted successfully');
              })
              .catch(error => {
                console.error('Failed to delete todo item:', error);
              });
        },

        toggleFilter(state) {
            console.log(state);
            this.filter = state;
        },
        clearAllCompletedTodo() {
            this.todos = this.todos.filter(todo=> todo.completed===false);
        },
        fetchTodoItems(){
          const name = sessionStorage.getItem('name');
          if (!name) {
            console.error('Username not found in Session Storage');
            return;
          }
          // 发送请求到后端获取待办事项列表数据
            axios.get(`http://localhost:8081/todo/select/?name=${name}`)
              .then(response => {
                this.todos = Object.values(response.data);
                console.log("response.data",response.data);
              })
              .catch(error => {
                console.error('Failed to fetch todo items:', error);
              });
      },
      updateTodoCompletion(todo) {
        const updateData = {
          id: todo.id,
          completed: todo.completed
        };
        axios.post('http://localhost:8081/todo/update', updateData)
            .then(response => {
              console.log('Todo item updated successfully');
            })
            .catch(error => {
              console.error('Failed to update todo item:', error);
            });
      }
    }
}
</script>

<style lang="stylus" scoped>
.real-app
    width 600px
    margin 0 auto
    box-shadow 0 0 5px #666

.header
  display flex
  justify-content flex-end
  padding 16px
  background-color #f5f5f5
  box-shadow 0 1px 5px rgba(0,0,0,0.1)

.username
  font-size 18px
  color #333

.add-input
    position relative
    margin 0
    width 100%
    font-size 24px
    font-family inherit
    font-weight inherit 
    line-height 1.4em
    border none
    outline none 
    color inherit 
    box-sizing border-box
    font-smoothing antialiased
    padding 16px 16px 16px 36px
    border none
    box-shadow inset 0 -2px 1px rgba(0, 0, 0, 0.03)

.priority-container
  display flex
  justify-content space-between
  align-items center
  box-shadow inset 0 -2px 1px rgba(0, 0, 0, 0.03)
  border none
  outline none
  color inherit
  box-sizing border-box
  font-smoothing antialiased
  padding 16px 16px 16px 36px
  border none

.priority-label
  font-size 24px
  font-family inherit
  font-weight inherit
  line-height 1.4em
  color inherit
  margin 0

.priority-select
  padding 8px 16px
  font-size 16px
  font-family inherit
  font-weight inherit
  line-height 1.4em
  border 1px solid #ccc
  border-radius 4px
  box-sizing border-box
  outline none
  color inherit
  background-color #fff
  box-shadow inset 0 -2px 1px rgba(0, 0, 0, 0.03)
  -webkit-appearance none
  -moz-appearance none
  appearance none
</style>


