<template>
  <div class="auth_bg" :style="{'background-image': `url(${require('@/assets/auth_bg.svg')})`}">
    <router-view/>
  </div>
</template>

<script>
export default {
    name: "AuthLayout"
};
</script>

<style scoped>
.auth_bg{
    min-height: 100vh;
    background-repeat: no-repeat;
    background-size: cover;
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>