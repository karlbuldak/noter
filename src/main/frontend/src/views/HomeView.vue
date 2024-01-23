<template>
  <div class="home">
    <h1>Welcome to Noter</h1>
    <h2>Take your note, and share it with friends!</h2>
  </div>
  <MakeNewNote />
</template>

<script>
import MakeNewNote from '@/components/MakeNewNote.vue';

export default {
  components: {
    MakeNewNote
  }
}
</script>

<style>
h1{
  font-size: 40px;
}
h2{
  font-weight: normal;
}
</style>
