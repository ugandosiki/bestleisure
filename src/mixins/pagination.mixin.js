import _ from "lodash"
import store from "../store"
export default {
    data() {
        return {
            page: +this.$route.query.page || 1,
            pageSize: 5,
            pageCount: 0,
            allPosts: store.state.post.posts,
            posts: []
        }
    },
    computed: {
        fetchedPosts(){
            return store.state.post.posts
        }
    },
    methods: {
        pChangeHandler(page) {
            this.$router.push({ path: this.$route.path, query: { page: page } }).catch(() => { })
            this.posts = this.allPosts[page - 1]
        },
        initPagination(allPosts) {
            this.allPosts = _.chunk(allPosts, this.pageSize)
            this.pageCount = _.size(this.allPosts)
            this.posts = this.allPosts[this.page - 1] || this.allPosts[0]
            console.log(this.allPosts)
        }
    }
}