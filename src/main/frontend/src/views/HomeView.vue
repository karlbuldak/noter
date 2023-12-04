<template>
  <div class="home">
    <h1>Welcome to Noter</h1>
    <p>Take your note, and share it with friends!</p>
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
