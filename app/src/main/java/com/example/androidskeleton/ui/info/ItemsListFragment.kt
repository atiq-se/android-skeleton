package com.example.androidskeleton.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.androidskeleton.R
import com.example.androidskeleton.data.datamodels.Article
import com.example.androidskeleton.data.event.ArticleEvent
import com.example.androidskeleton.databinding.FragmentItemsListBinding
import com.example.androidskeleton.ui.info.adapters.ArticlesAdapter
import com.example.androidskeleton.ui.viewmodel.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class ItemsListFragment : Fragment() {


    private var _binding: FragmentItemsListBinding? = null
    private val binding get() = _binding!!


    private val articleViewModel: ArticleViewModel by activityViewModels()
    private lateinit var articleAdapter: ArticlesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemsListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeArticleViewModel()
        binding.fabAddProduct.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addItemFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpRecyclerViewArticles(articleList: List<Article>) {
        binding.recyclerViewProducts.apply {
            articleAdapter =
                ArticlesAdapter(onArticleClick(), articleList) // pass your list here...
            adapter = articleAdapter
        }
    }

    private fun onArticleClick() = ArticlesAdapter.ArticleItemClickListener { data ->

    }

    private fun observeArticleViewModel() {
        articleViewModel.getAllArticles()
        viewLifecycleOwner.lifecycleScope.launch {
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                articleViewModel.articlesEvent.collect { events ->
                    when (events) {
                        is ArticleEvent.Articles -> {
                            setUpRecyclerViewArticles(events.articleList)
                        }

                        is ArticleEvent.Error -> {}
                        ArticleEvent.Loading -> {

                        }
                    }
                }
            }
        }
    }
}