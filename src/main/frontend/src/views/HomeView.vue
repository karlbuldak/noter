<template>
  <div class="home">
    <h1>Welcome to Noter</h1>
  </div>
  <NoteEditor />
</template>

<script>
import NoteEditor from '@/components/NoteEditor.vue';

export default {
  components: {
    NoteEditor
  }
}
</script>
