import _ from "lodash"
export default {
    data() {
        return {
            page: +this.$route.query.page || 1,
            pageSize: 5,
            pageCount: 0,
            allPosts: [{ id: 1, title: "Anton" },
            { id: 2, title: "Vadim" },
            { id: 3, title: "Gena" },
            { id: 4, title: "Andrew" },
            { id: 5, title: "Dima" },
            { id: 6, title: "Anton" },
            { id: 7, title: "Vadim" },
            { id: 8, title: "Gena" },
            { id: 9, title: "Andrew" },
            { id: 10, title: "Dima" },
            { id: 11, title: "Anton" },
            { id: 12, title: "Vadim" },
            { id: 13, title: "Gena" },
            { id: 14, title: "Andrew" },
            { id: 15, title: "Dima" },],
            posts: []
        }
    },
    methods: {
        pChangeHandler(page) { 
            this.$router.push({path: this.$route.path, query: {page: page}}).catch(()=>{})
            this.posts = this.allPosts[page - 1] || this.allPosts[0] 
        },
        initPagination(allPosts) {
            this.allPosts = _.chunk(allPosts, this.pageSize)
            this.pageCount = _.size(this.allPosts)
            this.posts = this.allPosts[this.page - 1] || this.allPosts[0]
        }
    }
}