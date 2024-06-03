<!--item.vue-->
<template>
    <div :class="['todo-item', todo.completed? 'completed': '']">
        <input 
            type="checkbox"
            class="toggle" 
            v-model="todo.completed"
            @change="toggleComplete"
        >
      <label :for="'todo-' + todo.id">{{ todo.title }}</label>
      <span :class="['priority', priorityClass]">{{ priorityText }}</span>
        <button class="destory" @click="deleteTodo"></button>
    </div>
</template>

<script>
export default {
    props: {
        todo: {
            type: Object,
            required: true
        }
    },
  computed: {
    priorityText() {
      switch (this.todo.priority) {
        case 1:
          return 'High';
        case 2:
          return 'Mid';
        case 3:
          return 'Low';
        default:
          return '';
      }
    },
    priorityClass() {
      switch (this.todo.priority) {
        case 1:
          return 'high-priority';
        case 2:
          return 'mid-priority';
        case 3:
          return 'low-priority';
        default:
          return '';
      }
    }
  },
    methods: {
        deleteTodo() {
            this.$emit('del', this.todo.id);
        },
      toggleComplete() {
        this.$emit('toggle-complete', this.todo);
      }
    }
}
</script>

<style lang="stylus" scoped>
.todo-item
  position relative
  background-color #fff
  font-size 24px
  border-bottom 1px solid rgba(0,0,0,0.06)
  display flex
  align-items center
  &:hover
    .destory:after
      content 'x'
  label
    white-space pre-line
    word-break break-all
    padding 15px 60px 15px 15px
    margin-left 45px
    display block
    line-height 1.2
    transition color 0.4s
  .priority
    margin-left auto
    padding-right 50px
    color #666
  .high-priority
    color red
  .mid-priority
    color orange
  .low-priority
    color green
  &.completed
    label
      color #d9d9d9
      text-decoration line-through
    .priority
      color #d9d9d9
      text-decoration line-through
.toggle
  text-align center
  width 50px
  height 30px
  position absolute
  top 0
  bottom 0
  margin auto 0
  border none
  appearance none
  outline none
  &:after
    content url('../assets/images/unChecked.svg')

  &:checked:after
    content url('../assets/images/checked.svg')
.destory
  position absolute
  top 0
  right 10px
  bottom 0
  width 40px
  height 40px
  margin auto 0
  font-size 30px
  color #cc9a9a
  margin-bottom 11px
  transition color 0.2s ease-out
  background-color transparent
  appearance none
  border-width 0
  cursor pointer
  outline none
</style>