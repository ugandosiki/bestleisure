<template>
  <div class="post">
    <span
      class="user-menu fixed-left"
      v-if="postData.user.role.name == 'ROLE_OWNER' && postData.user.email== $store.state.auth.user.email"
    >
      <q-btn
        icon="widgets"
        color="primary"
        style="border-radius: 0px"
        @click="open('left')"
      />
    </span>
    <q-dialog v-model="dialog" :position="position">
      <q-card style="width: 200px">
        <q-card-section class="row">
          <div class="btns">
            <q-btn
              label="Добавить рекламу"
              color="teal"
              style="border-radius: 0px"
              @click="bannerDialog = true"
            />
            <q-dialog
              ref="dialog"
              v-model="bannerDialog"
              transition-show="scale"
              transition-hide="scale"
            >
              <div class="form-div q-pa-md">
                <q-form
                  class="q-gutter-md"
                  @submit.prevent="addBanner()"
                  method="post"
                  enctype="multipart/form-data"
                >
                  <q-input
                    filled
                    v-model="banner.title"
                    square
                    outlined
                    label="Название*"
                    hint="Введите название страны"
                    lazy-rules
                    name="title"
                    :rules="[
                      (val) =>
                        (val && val.length > 0) || 'Please type something',
                    ]"
                  />
                  <div>
                    <q-input
                      v-model="banner.description"
                      filled
                      square
                      outlined
                      autogrow
                      label="Описание*"
                      hint="Введите описание"
                      name="description"
                      lazy-rules
                      :rules="[
                        (val) =>
                          (val && val.length > 0) || 'Please type something',
                      ]"
                    />

                    <q-file
                      color="dark-12"
                      v-model="bannerImage"
                      label="Выберите изображения для баннера"
                      counter
                      name="file"
                      max-files="1"
                      style="min-width: 365px; max-width: 97%"
                    >
                      <template v-slot:prepend>
                        <q-icon name="attach_file" />
                      </template>
                    </q-file>
                    <q-btn
                      label="Добавить баннер"
                      type="submit"
                      color="primary"
                    />
                  </div>
                </q-form>
              </div>
            </q-dialog>
            <q-btn
              label="Редактировать описание"
              color="teal"
              style="border-radius: 0px"
              @click="open('left')"
            />
            <q-btn
              label="Изменить название"
              color="teal"
              style="border-radius: 0px"
              @click="open('left')"
            />
            <q-btn
              label="Сменить изображение"
              color="teal"
              style="border-radius: 0px"
              @click="open('left')"
            />
          </div>
        </q-card-section>
      </q-card>
    </q-dialog>
    <div class="post_content shadow-4">
      <div class="q-col-gutter-md row items-start">
        <div class="col-12">
          <q-img :src="src + postImage.path" style="width: 100%; height: 300px">
            <div class="absolute-bottom text-subtitle3 text-center">
              <span class="post-title">{{ postData.title }}</span>
            </div>
          </q-img>
        </div>
      </div>
      <div class="post-descr">
        <span class="descr-title">О ЗАВЕДЕНИИ</span><br />
        <p>{{ postData.description }}</p>
      </div>
      <div class="post-banners">
        <span class="banner-title">АКЦИИ</span><br />
        <div class="banners-content">
          <banner-component
            class="banner"
            v-for="banner in postData.banners"
            :key="banner.id"
            :banner="banner"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Banner from "@/models/banner";
import BannerComponent from "../../components/pages/catalog/BannerComponent.vue";
export default {
  components: { BannerComponent },
  name: "PostPage",
  data() {
    return {
      src: "http://localhost:8080/uploads/",
      dialog: false,
      position: "left",
      bannerDialog: false,
      banner: new Banner("", "", ""),
      bannerImage: [],
      menuVisible: false,
    };
  },
  computed: {
    postData() {
      let posts = this.$store.state.post.posts;
      let post = {};
      posts.forEach((e) => {
        if (e.id == this.$route.params.id) {
          post = e;
        }
      });
      return post;
    },
    postImage() {
      let postImage = {};
      this.postData.images.forEach((e) => {
        if (e.path.match(/Post/g)) {
          postImage = e;
          console.log(postImage);
        }
      });
      return postImage;
    },
  },
  methods: {
    open(position) {
      this.position = position;
      this.dialog = true;
    },
    addBanner() {
      console.log(this.banner);
      let data = {
        b: this.banner,
        i: this.bannerImage,
        p: this.postData.id,
      };
      this.$store.dispatch("banner/create", { data });
      this.$refs.dialog.hide();
    },
  },
};
</script>

<style scoped>
.post {
  display: flex;
  justify-content: center;
  padding-top: 3%;
}
.post_content {
  margin: auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 70%;
  background-color: rgba(255, 255, 255, 0.8);
}
.post-title {
  font-size: 18pt;
  text-transform: uppercase;
}
.descr-title {
  background-color: rgba(0, 0, 0, 0.3);
  width: 300px;
  padding: 5px 0px;
  height: 40px;
  text-align: center;
  position: absolute;
}
.banner-title {
  background-color: rgba(0, 0, 0, 0.5);
  font-size: 16pt;
  color: white;
  position: absolute;
  margin-top: 5px;
  text-align: center;
  width: 300px;
  padding: 5px 0px;
  height: 42px;
}
.banners-content {
  margin-top: 10px;
  width: 100%;
}
.post-descr {
  padding-top: 10px;
  font-size: 14pt;
  color: white;
  text-align: justify;
  background-color: teal;
}
.post-descr p {
  padding: 20px;
}
.post-banners {
  background-color: white;
  display: flex;
  text-align: center;
  padding-bottom: 50px;
}
.banner {
  margin-left: 20px;
  width: 31%;
}
.user-menu {
  height: 30px;
  top: 46.5%;
}
.btns {
  width: 200px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.btns .q-btn {
  margin-top: 10px;
}
.form-div {
  margin: auto;
  width: 100%;
  background-color: rgba(255, 255, 255, 1);
}
</style>