<template>
  <HelloWorld />
<!--  <RegisterForm/>-->
</template>

<script>
  import HelloWorld from '@/components/HelloWorld.vue'
  import RegisterForm from "@/components/RegisterForm";
  export default {
    components: {
      HelloWorld, RegisterForm
    },
    name: "Home",
  }
</script>
