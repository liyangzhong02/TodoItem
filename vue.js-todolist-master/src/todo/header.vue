<template>
    <header class="main-header">
        <h1>Todo</h1>
      <div class="header">
<!--        <span class="username">{{ username }}</span>-->
      </div>
    </header>

</template>

<style lang="stylus" scoped>
.main-header
    text-align center
    h1
        font-size 100px
        //color rgba(175,47,47,0.4)
        font-weight 400
        margin 20px
</style>
<script>
export default {
  data() {
    return {
      username: ''
    }
  },
  created() {
    this.username = sessionStorage.getItem('name') || 'Guest';
  },
}
</script>