<template>
  <div class="interesting">
    <div class="block_title">
     <span>Самое интересное</span>
    </div>
    <div class="block_posts">
        <div class="post">
            gfhfg
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "InterestingComponent",
};
</script>

<style scoped>
.interesting {
  background-color: white;
  width: 100%;
}
.block_title {
  font-size: 18pt;
}
.block_title{
    font-size: 16pt;
    text-align: center;
}
.block_title span::before, .block_title span::after{
    content: "";
    display: inline-block;
    margin: 0px 10px;
    height: 1px;
    width: 200px;
    background-color: black;
    vertical-align: middle;
}
</style>